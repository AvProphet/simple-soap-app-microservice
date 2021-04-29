package com.soap.webservices.soapfirstapp.soap.service;

import com.soap.webservices.soapfirstapp.soap.bean.DetailInstance;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class DetailsService {

    private static List<DetailInstance> details = new ArrayList<>();

    static {
        DetailInstance detail1 = new DetailInstance(1, "Book Detail", "Some details about book");
        details.add(detail1);

        DetailInstance detail2 = new DetailInstance(2, "Game Detail", "Some details about game");
        details.add(detail2);

        DetailInstance detail3 = new DetailInstance(3, "Manga Detail", "Some details about manga");
        details.add(detail3);

        DetailInstance detail4 = new DetailInstance(4, "Programming language Detail", "Some details about programming language");
        details.add(detail4);
    }


    //GetDetails - 1
    //fond by Id
    public DetailInstance findById (int id) {
        for (DetailInstance detail: details) {
            if (detail.getId()==id)
                return detail;
        }
        return null;
    }

    //All details - 2
    //List
    public List<DetailInstance> findAll() {
        return details;
    }

    //deleteDetails
    //Detail delete by Id

    public int deleteById(int id) {

        Iterator<DetailInstance> iterator = details.iterator();

        while (iterator.hasNext()){
            DetailInstance detail = iterator.next();
            if (detail.getId()==id)
                iterator.remove();
                return 1;
        }
        return 0;
    }

}
