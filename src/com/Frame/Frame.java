package com.Frame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Component;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Frame extends JFrame implements ActionListener {
    private JButton Load;
    private JButton Create;
    private JButton Delete;
    private JButton Save;
    private JButton Cancel;
    private JPanel JPanel_Left;
    private JPanel JPanel_Right;
    private JPanel JPanel_Right1;
    private JPanel JPanel_Right2;
    private JPanel JPanel_Right3;
    private JPanel JPanel_Right4;
    private JPanel JPanel_Right5;
    private JTable InvoiceTable;
    private JTable DetailedTable;
    private JLabel labelInvoiceNumber = new JLabel();
    private JLabel labelInvoiceDate = new JLabel();
    private JTextField InvoiceNumTXT = new JTextField(2);
    private JTextField InvoiceDateTXT = new JTextField(20);
    private JLabel labelInvoiceCustomerName = new JLabel();
    private JTextField CustomerNameTXT = new JTextField(20);
    private JLabel labelInvoiceTotal = new JLabel();
    private JTextField InvoiceTotalTXT = new JTextField(4);

    private String[] InvoiceCols = {"No.", "Date", "Customer Name", "Total "};
    Object[][] InvoiceRow = new Object[3][InvoiceCols.length];

    private String[] DetailedCols = {"No.", "Item Name", "Item Price", "Count", "Item Total "};
    Object[][] DetailedRow = new Object[3][DetailedCols.length];

    public Frame() {
        super("Sales Invoices Generator");

        setSize(1000, 700);
        setLocation(300, 150);
        setLayout(new FlowLayout());

        JPanel_Left = new JPanel();
        JPanel_Right = new JPanel();
        JPanel_Right.setLayout(new BoxLayout(JPanel_Right, BoxLayout.PAGE_AXIS));

        JPanel_Right1 = new JPanel();
        JPanel_Right2 = new JPanel();
        JPanel_Right3 = new JPanel();
        JPanel_Right4 = new JPanel();
        JPanel_Right5 = new JPanel();

        //Load File
        Load = new JButton("Load File");
        add(BorderLayout.SOUTH, Load);
        Load.addActionListener(this);
        //Main table
        InvoiceTable = new JTable(InvoiceRow, InvoiceCols);
        JPanel_Left.add(new JScrollPane(InvoiceTable));

        //label & text one
        labelInvoiceNumber.setText("Invoice Number");
        InvoiceNumTXT.setText("0");
        InvoiceNumTXT.setEditable(false);

        JPanel_Right1.setLayout(new FlowLayout());
        JPanel_Right1.add(labelInvoiceNumber);
        JPanel_Right1.add(InvoiceNumTXT, BorderLayout.CENTER);

        JPanel_Right.add(JPanel_Right1);


        //label & text two
        labelInvoiceDate.setText("Invoice Date");
        JPanel_Right2.add(labelInvoiceDate);
        JPanel_Right2.add(InvoiceDateTXT);
        JPanel_Right2.setLayout(new FlowLayout());
        JPanel_Right.add(JPanel_Right2);

        //label & text three
        labelInvoiceCustomerName.setText("Customer Name");
        JPanel_Right3.add(labelInvoiceCustomerName);
        JPanel_Right3.add(CustomerNameTXT);
        JPanel_Right3.setLayout(new FlowLayout());
        JPanel_Right.add(JPanel_Right3);

        //label & text Four
        labelInvoiceTotal.setText("Invoice Total");
        JPanel_Right4.add(labelInvoiceTotal);
        InvoiceTotalTXT.setText("0");
        InvoiceTotalTXT.setEditable(false);
        JPanel_Right4.add(InvoiceTotalTXT);
        JPanel_Right4.setLayout(new FlowLayout());
        JPanel_Right.add(JPanel_Right4);

        //DetailedTable table
        InvoiceTable = new JTable(DetailedRow, DetailedCols);
        JPanel_Right5.add(new JScrollPane(InvoiceTable));
        JPanel_Right5.setLayout(new FlowLayout());
        JPanel_Right.add(JPanel_Right5);


        JSplitPane sl = new JSplitPane(SwingConstants.VERTICAL, JPanel_Left, JPanel_Right);
        sl.setOrientation(SwingConstants.VERTICAL);

        add(sl);

        //Btns
        Create = new JButton("Create New Invoice");
        add(BorderLayout.SOUTH, Create);
        Create.addActionListener(this);

        Delete = new JButton("Delete Invoice");
        add(BorderLayout.SOUTH, Delete);
        Delete.addActionListener(this);


        Save = new JButton("Save");
        add(BorderLayout.SOUTH, Save);
        Save.addActionListener(this);

        Cancel = new JButton("Cancel");
        add(BorderLayout.SOUTH, Cancel);
        Cancel.addActionListener(this);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(Create)) {
            JOptionPane.showMessageDialog(null,
                    "c",
                    "Information_Message",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource().equals(Delete)) {
            JOptionPane.showMessageDialog(null,
                    "D",
                    "Information_Message",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource().equals(Save)) {
            JOptionPane.showMessageDialog(null,
                    "S",
                    "Information_Message",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource().equals(Cancel)) {
            JOptionPane.showMessageDialog(null,
                    "Cancle",
                    "Information_Message",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource().equals((Load))) {
            /*
            File excelFile;
            FileInputStream excelFIS = null;
            BufferedInputStream excelBIS = null;
            XSSFWorkbook excelImportToJTable = null;
            String defaultCurrentDirectoryPath = "C:\\Users\\sherif.mounir\\Downloads\\sales-invoice-generator\\Sales Invoice Generator";
            JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
            excelFileChooser.setDialogTitle("Select Excel File");
            FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm","csv");
            excelFileChooser.setFileFilter(fnef);
            int excelChooser = excelFileChooser.showOpenDialog(null);
            if (excelChooser == JFileChooser.APPROVE_OPTION) {
                try {
                    excelFile = excelFileChooser.getSelectedFile();
                    excelFIS = new FileInputStream(excelFile);
                    excelBIS = new BufferedInputStream(excelFIS);
                    excelImportToJTable = new XSSFWorkbook(excelBIS);
                    XSSFSheet excelSheet = excelImportToJTable.getSheetAt(0);

                    for (int row = 0; row < excelSheet.getLastRowNum(); row++) {
                        XSSFRow excelRow = excelSheet.getRow(row);

                        XSSFCell InvoiceNo = excelRow.getCell(0);
                        XSSFCell InvoiceDate = excelRow.getCell(1);
                        XSSFCell CustomerName = excelRow.getCell(2);
                       // XSSFCell excelSubject = excelRow.getCell(3);
                        //XSSFCell excelImage = excelRow.getCell(4);

                    }
                    JOptionPane.showMessageDialog(null, "Imported Successfully !!.....");
                } catch (IOException iOException) {
                    JOptionPane.showMessageDialog(null, iOException.getMessage());
                } finally {
                    try {
                        if (excelFIS != null) {
                            excelFIS.close();
                        }
                        if (excelBIS != null) {
                            excelBIS.close();
                        }
                        if (excelImportToJTable != null) {
                            excelImportToJTable.close();
                        }
                    } catch (IOException iOException) {
                        JOptionPane.showMessageDialog(null, iOException.getMessage());
                    }
                }
                            }

*/
        }

    }
}