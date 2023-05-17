package files;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.example.User;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class CreatePDFS {


    public CreatePDFS(int i) {


        if(i==1){   // TRANSACTION HISTORY PDF \\

            Document document = new Document();


            try {
                // ...

                // get the desktop directory
                String desktopPath = System.getProperty("user.home") + "/Desktop";

                // get current date and time
                LocalDateTime currentDateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd_HH.mm.ss");
                //String formattedDateTime = currentDateTime.format(formatter).replace(":", "");
                String formattedDateTime = currentDateTime.format(formatter);


                String pdfPath = desktopPath + "/transactions_" + formattedDateTime + ".pdf";
                PdfWriter.getInstance(document, new FileOutputStream(pdfPath));

                // open the document
                document.open();
                // Set up font styles
                Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, BaseColor.BLACK);
                Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.DARK_GRAY);
                Font contentFont = FontFactory.getFont(FontFactory.COURIER, 10, BaseColor.BLACK);



                // Photo
                String imagePath = "src/main/java/files/LOGO.png";
                Image image = Image.getInstance(imagePath);
                image.scaleToFit(200, 200);
                image.setAlignment(Image.ALIGN_CENTER);
                document.add(image);


                PdfPTable headerTable = new PdfPTable(1);
                headerTable.setWidthPercentage(100f);

                // Add the name to the header table
                PdfPCell textCell = new PdfPCell();
                textCell.setBorder(Rectangle.NO_BORDER);
                textCell.setVerticalAlignment(Element.ALIGN_TOP);
                textCell.addElement(new Phrase("GIANNIS SFYRAKIS", titleFont));
                textCell.addElement(new Phrase("GR23794784367", contentFont));
                headerTable.addCell(textCell);

                // Add the header table to the document
                document.add(headerTable);

                // Add the title
                Paragraph title = new Paragraph("Transaction History", titleFont);
                title.setAlignment(Paragraph.ALIGN_CENTER);
                title.setSpacingAfter(20); // Add some spacing after the title
                document.add(title);

                // Add a table of transactions
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String[] headers = {"Transaction ID", "Date", "Description", "Amount"};
                String[][] data = {
                        {"000001", dateFormat.format(new Date()), "Payment from John Smith", "$100.00"},
                        {"000002", dateFormat.format(new Date()), "Refund to Jane Doe", "-$50.00"},
                        {"000003", dateFormat.format(new Date()), "Payment from Joe Brown", "$75.00"},
                        {"000004", dateFormat.format(new Date()), "Payment from Sarah Lee", "$200.00"}
                };
                PdfPTable table = new PdfPTable(headers.length);
                table.setWidthPercentage(100f);
                for (String header : headers) {
                    PdfPCell cell = new PdfPCell(new Paragraph(header, headerFont));
                    cell.setPadding(5);
                    cell.setBackgroundColor(BaseColor.LIGHT_GRAY); // Set the background color of header cells
                    table.addCell(cell);
                }
                for (String[] row : data) {
                    for (String cell : row) {
                        table.addCell(new Paragraph(cell, contentFont));
                    }
                }
                table.setSpacingAfter(20); // Add some spacing after the table
                document.add(table);

                // Close the document
                document.close();

                System.out.println("PDF created successfully!");

            } catch (DocumentException | IOException e) {
                e.printStackTrace();
            }

//            try {
//
//                // get the desktop directory
//                String desktopPath = System.getProperty("user.home") + "/Desktop";
//
//                // get current date and time
//                LocalDateTime currentDateTime = LocalDateTime.now();
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd_HH.mm.ss");
//                //String formattedDateTime = currentDateTime.format(formatter).replace(":", "");
//                String formattedDateTime = currentDateTime.format(formatter);
//
//
//                String pdfPath = desktopPath + "/transactions_" + formattedDateTime + ".pdf";
//                PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
//
//                // open the document
//                document.open();
//
//                // set font for the document
//                Font font = FontFactory.getFont(FontFactory.COURIER, 12);
//
//                // photo
//                String imagePath = "src/main/java/files/LOGO.png";
//                Image image = Image.getInstance(imagePath);
//                image.scaleToFit(200, 200);
//                image.setAlignment(Image.ALIGN_CENTER);
//                document.add(image);
//
//
//                Paragraph title = new Paragraph("Transaction History", font);
//                title.setAlignment(Paragraph.ALIGN_CENTER);
//                document.add(title);
//
//                // add a table of transactions
//                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                String[] headers = {"Transaction ID", "Date", "Description", "Amount"};
//                String[][] data = {
//                        {"000001", dateFormat.format(new Date()), "Payment from John Smith", "$100.00"},
//                        {"000002", dateFormat.format(new Date()), "Refund to Jane Doe", "-$50.00"},
//                        {"000003", dateFormat.format(new Date()), "Payment from Joe Brown", "$75.00"},
//                        {"000004", dateFormat.format(new Date()), "Payment from Sarah Lee", "$200.00"}
//                };
//                PdfPTable table = new PdfPTable(headers.length);
//                table.setWidthPercentage(100f);
//                for (String header : headers) {
//                    PdfPCell cell = new PdfPCell(new Paragraph(header, font));
//                    cell.setPadding(5);
//                    table.addCell(cell);
//                }
//                for (String[] row : data) {
//                    for (String cell : row) {
//                        table.addCell(new Paragraph(cell, font));
//                    }
//                }
//                document.add(table);
//
//                // close the document
//                document.close();
//
//                System.out.println("PDF created successfully!");
//
//            } catch (DocumentException | IOException e) {
//                e.printStackTrace();
//            }

        }

    }
}