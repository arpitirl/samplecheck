package com.training.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.stream.Stream;

import org.dhatim.fastexcel.reader.ReadableWorkbook;
import org.dhatim.fastexcel.reader.Row;
import org.dhatim.fastexcel.reader.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.training.processor.Processor;
import com.training.reader.Reader;
import com.training.response.SuccessResponse;

import lombok.var;
@Service
public class RegistrationService {
	
	@Autowired
	private Processor processor;
	public Dictionary read(MultipartFile file) throws IOException {
//		Reader reader=new Reader();
//		SuccessResponse response=new SuccessResponse();
		
//		System.out.println("service");
////		System.out.println(reader.read(file));
//		Dictionary transaction=reader.read(file);
//		transaction.remove("");
//		return transaction; 
		file.transferTo(new File("C:\\Users\\arpit.shreshth\\Downloads\\Fast-Reader-main\\Fast-Reader-main\\Fast\\src\\main"+file.getOriginalFilename()));
		
		String dest="C:\\Users\\arpit.shreshth\\Downloads\\Fast-Reader-main\\Fast-Reader-main\\Fast\\src\\main"+file.getOriginalFilename();
		List<String> list=new ArrayList<String>();
		

        var f = new File(dest);

        try (var wb = new ReadableWorkbook(f)) {

            Sheet sheet = wb.getFirstSheet();
            

            try (Stream<Row> rows = sheet.openStream()) {

                var it = rows.iterator();

                int i = 0;
                while (it.hasNext()) {
                	
                	
                	

                    var row = it.next();
                    System.out.println();
                    
                    row.stream().forEach(cell -> list.add(cell.getText()));
                    if(i==4) {
                    	System.out.println("Reader");
                    	System.out.println("Current Thread Name- " + Thread.currentThread().getName());
                		System.out.println(list);
                		processor.process(list);
                		i=0;
                		list.clear();
                		System.out.println(list);
                	}

                    i++;
                }
                }
                System.out.println(list.size());
            }
        
        return(processor.process(list))	;
	}

}
