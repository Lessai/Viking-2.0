package com.dp.viking.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import com.dp.viking.domain.dto.EmploymentContractContext;
import org.springframework.stereotype.Service;
import org.wickedsource.docxstamper.DocxStamper;
import org.wickedsource.docxstamper.DocxStamperConfiguration;

@Service
public class DocxService {
    public void createEmploymentContractDoc() throws IOException {
        DocxStamper<EmploymentContractContext> stamper = new DocxStamper<>(new DocxStamperConfiguration());
        EmploymentContractContext context = new EmploymentContractContext();

        context.setName("Vika");

        InputStream template = new FileInputStream(new File(EmploymentContractContext.getTemplateDocPathDocPath() + "Шаблон_приказа_о_найме.docx"));
        String uuidFile = UUID.randomUUID().toString();
        OutputStream out = new FileOutputStream(EmploymentContractContext.getReadyDocPath() + context.getName()+"_"+ uuidFile +".docx");
        stamper.stamp(template, context, out);
        out.close();
    }
}