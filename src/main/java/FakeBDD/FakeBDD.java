package FakeBDD;

import com.gestionnairetache.model.TacheDAO;

import java.util.ArrayList;

public  class FakeBDD {

   public static ArrayList<TacheDAO> taches = new ArrayList<TacheDAO>() {
        {
            add(new TacheDAO("1", "premiereTache", false));
            add(new TacheDAO("2", "deuxiemeTache", false));
            add(new TacheDAO("3", "troisiemeTache", true));
            add(new TacheDAO("4", "quatriemeTache", false));
        }
    };


}
