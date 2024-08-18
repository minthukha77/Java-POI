package com.mtk.poi.Service;

import org.springframework.stereotype.Service;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import com.mtk.poi.Helper.Helper;
import com.mtk.poi.Model.Category;
import com.mtk.poi.Repo.CategoryRepo;

@Service
public class ExcelService {

    CategoryRepo categoryRepo;

    public ExcelService(CategoryRepo categoryRepo){
        this.categoryRepo = categoryRepo;
    }

    public ByteArrayInputStream getActualData() throws IOException{
        List<Category> all = categoryRepo.findAll();

        ByteArrayInputStream byteArrayInputStream = Helper.dataToExcel(all);
        return byteArrayInputStream;
    }
    
}
