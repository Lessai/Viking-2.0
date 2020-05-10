package com.dp.viking.service;

import java.io.*;
import java.util.Date;
import java.util.UUID;

import com.dp.viking.domain.dto.DismissalOrderContext;
import com.dp.viking.domain.dto.EmploymentContractContext;
import org.springframework.stereotype.Service;
import org.wickedsource.docxstamper.DocxStamper;
import org.wickedsource.docxstamper.DocxStamperConfiguration;

@Service
public class DocxService {
    public void createEmploymentContractDoc(
            String departmentName,
            Date dateIn,
            String firstName,
            String secondName,
            String title,
            String categoryName
    ) throws IOException {
        DocxStamper<EmploymentContractContext> stamper = new DocxStamper<>(new DocxStamperConfiguration());
        EmploymentContractContext context = new EmploymentContractContext();

        context.setFirstName(firstName);
        context.setSecondName(secondName);
        context.setDepartmentName(departmentName);
        context.setTitle(title);
        context.setCategoryName(categoryName);
        context.setDateIn(dateIn);

        InputStream template = new FileInputStream(new File(EmploymentContractContext.getTemplateDocPathDocPath() + "Шаблон_договора_о_найме.docx"));
        String uuidFile = UUID.randomUUID().toString();
        OutputStream out = new FileOutputStream(EmploymentContractContext.getReadyDocPath() + context.getFirstName()+"_"+ context.getSecondName() +"_"+ uuidFile +".docx");
        stamper.stamp(template, context, out);
        out.close();
    }

    public void createDismissalOrderDoc(Date dateOut,
                                        Date dateIn,
                                        String firstName,
                                        String secondName,
                                        String title,
                                        String dismissionReason) throws IOException {
        DocxStamper<DismissalOrderContext> stamper = new DocxStamper<>(new DocxStamperConfiguration());
        DismissalOrderContext context = new DismissalOrderContext();

        context.setFirstName(firstName);
        context.setSecondName(secondName);
        context.setTitle(title);
        context.setDateIn(dateIn);
        context.setDateOut(dateOut);
        context.setDismissionReason(dismissionReason);

        InputStream template = new FileInputStream(new File(EmploymentContractContext.getTemplateDocPathDocPath() + "Шаблон_приказа_об_увольнении.docx"));
        String uuidFile = UUID.randomUUID().toString();
        OutputStream out = new FileOutputStream(EmploymentContractContext.getReadyDocPath() + context.getFirstName()+"_"+ context.getSecondName() +"_"+ uuidFile +".docx");
        stamper.stamp(template, context, out);
        out.close();
    }
}