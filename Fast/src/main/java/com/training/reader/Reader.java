package com.training.reader;



import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.stream.Stream;

import org.dhatim.fastexcel.reader.ReadableWorkbook;
import org.dhatim.fastexcel.reader.Row;
import org.dhatim.fastexcel.reader.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.training.entity.Register;
import com.training.processor.Processor;
import com.training.response.SuccessResponse;

import lombok.var;



public class Reader {
	
	@Autowired
	private Processor processor;
	
	public Dictionary read(MultipartFile file) throws IOException {
		file.transferTo(new File("C:\\Users\\arpit.shreshth\\Downloads\\Fast-Reader-main\\Fast-Reader-main\\Fast\\src\\main"+file.getOriginalFilename()));
		System.out.println("Reader");
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
