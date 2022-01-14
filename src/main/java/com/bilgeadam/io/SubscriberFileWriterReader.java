package com.bilgeadam.io;

import com.bilgeadam.dto.SubScriberDto;
import lombok.extern.log4j.Log4j2;

import java.io.*;

@Log4j2
public class SubscriberFileWriterReader {
    private static final String PATH = "C:\\file\\subscriber.txt";

    public void bilgeadamFileWriter(SubScriberDto subScriberDto) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH, true))) {
            bufferedWriter.write(String.valueOf(subScriberDto));
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void bilgeadamFileReader() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH))) {
            //numberRow=satır
            //sumRow=toplam satır
            String countRow = "", sumRow = "";
            while ((countRow = bufferedReader.readLine()) != null) {
                sumRow = countRow + sumRow;
            }
            log.info(sumRow);
        } catch (IOException ioException) {
            ioException.printStackTrace();

        }
    }

}
