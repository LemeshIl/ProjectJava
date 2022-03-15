package com.project;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.*;
import com.project.model.Person;

import java.awt.Color;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class PersonPDFExporter {

    private Person person;

    public PersonPDFExporter(Person person) {
        this.person = person;
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("id", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("fullname", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("birthday", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("creditamount", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("termmonth", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("allowed", font));
        table.addCell(cell);
    }


    private void writeTableData(PdfPTable table) {

        table.addCell(String.valueOf(person.getId()));
        table.addCell(person.getFullName());
        table.addCell(String.valueOf(person.getBirthDay()));
        table.addCell(String.valueOf(person.getCreditAmount()));
        table.addCell(String.valueOf(person.getTermMonth()));
        table.addCell(String.valueOf(person.isAllowed()));
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("Persons", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100f);
        table.setWidths(new float[]{1.5f, 1.5f, 1.5f, 1.5f, 1.5f, 1.5f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);
        document.add(table);
        document.close();
    }
}
