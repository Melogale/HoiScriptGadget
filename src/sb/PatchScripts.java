package sb;

import java.io.File;
import java.util.ArrayList;

public class PatchScripts {

    public static final String hoiPath = "D:/Programs/Steam/steamapps/common/Hearts of Iron IV";
    public static final String[] baseTags = {"GER", "ENG", "SOV", "SWE", "FRA", "LUX", "BEL", "HOL", "CZE", "POL", "AUS", "LIT", "EST", "LAT", "SPR", "ITA", "ROM", "YUG", "SER", "SWI", "TUR", "GRE", "ALB", "NOR", "DEN", "BUL", "POR", "FIN", "IRE", "HUN", "AFG", "ARG", "AST", "BHU", "BOL", "BRA", "CAN", "CHI", "CHL", "COL", "COS", "ECU", "ELS", "ETH", "GUA", "HON", "IRQ", "JAP", "KOR", "LIB", "MEX", "MEN", "NEP", "NIC", "NZL", "PAN", "PER", "PHI", "PRU", "SAF", "SAU", "SIA", "SIK", "TIB", "URG", "VEN", "YUN", "USA", "MON", "TAN", "PAR", "CUB", "DOM", "HAI", "YEM", "OMA", "SLO", "RAJ", "CRO", "GXC", "PRC", "SHX", "XSM", "ICE", "LEB", "JOR", "SYR", "EGY", "LBA", "WGR", "DDR", "PAL", "ISR", "VIN", "CAM", "MAL", "INS", "LAO", "MNT", "UKR", "GEO", "KAZ", "AZR", "ARM", "BLR", "ANG", "MZB", "ZIM", "COG", "KEN", "PAK", "BOT", "MAN", "BAH", "BAN", "BLZ", "BRM", "CRC", "GDL", "GYA", "JAM", "KYR", "MAD", "MOL", "PNG", "PUE", "QAT", "SCO", "SRL", "SUR", "TAJ", "TRI", "TMS", "UAE", "UZB", "KUW", "CYP", "MLT", "ALG", "MOR", "TUN", "SUD", "ERI", "DJI", "SOM", "UGA", "RWA", "BRD", "TZN", "ZAM", "MLW", "GAB", "RCG", "EQG", "CMR", "CAR", "CHA", "NGA", "DAH", "TOG", "GHA", "IVO", "VOL", "MLI", "SIE", "GNA", "GNB", "SEN", "GAM", "WLS", "NGR", "CSA", "USB", "MRT", "NMB", "WES", "BAS", "CAY", "MLD", "FIJ", "FSM", "TAH", "GUM", "SOL", "SAM", "HAW", "SLV", "BOS", "HRZ", "MAC", "NIR", "BAY", "MEK", "PRE", "SAX", "HAN", "WUR", "SHL", "CAT", "NAV", "GLC", "ADU", "BRI", "OCC", "COR", "KUR", "TRA"};
    public static final String[] extraKeywords = {"fascism, democratic, communism"};


    public static ArrayList<File> allTextFiles(File root) {
        ArrayList<File> txtFiles = new ArrayList<File>();
        File[] files = root.listFiles();
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                txtFiles.add(file);
            } else if (file.isDirectory()) {
                txtFiles.addAll(allTextFiles(file));
            }
        }
        return txtFiles;
    }

    public static ArrayList<File> markKeyWords(ArrayList<File> files) {
        ArrayList<File> matches = new ArrayList<File>();
        for(int i = 0; i < files.size(); i++) {
            String text = Scripts.readFile(files.get(i));
            boolean contains = false;
            for(int j = 0; j < baseTags.length; j++) {
                if(text.contains(baseTags[j])) {
                    contains = true;
                    break;
                }
            }
            for(int k = 0; k < extraKeywords.length; k++) {
                if(text.contains(extraKeywords[k])) {
                    contains = true;
                    break;
                }
            }
            if(contains) {
                matches.add(files.get(i));
            }
        }
        return matches;
    }

    public static ArrayList<File> keyWordFiles(ArrayList<File> files) {
        ArrayList<File> matches = new ArrayList<File>();
        for(int i = 0; i < files.size(); i++) {
            String text = Scripts.readFile(files.get(i));
            boolean contains = false;
            for(int j = 0; j < baseTags.length; j++) {
                if(text.contains(baseTags[j])) {
                    contains = true;
                    break;
                }
            }
            for(int k = 0; k < extraKeywords.length; k++) {
                if(text.contains(extraKeywords[k])) {
                    contains = true;
                    break;
                }
            }
            if(contains) {
                matches.add(files.get(i));
            }
        }
        return matches;
    }

    public static void printNames(ArrayList<File> files) {
        for(int i = 0; i < files.size(); i++) {
            System.out.println(files.get(i).getName());
        }
    }
    public static void printPaths(ArrayList<File> files) {
        for(int i = 0; i < files.size(); i++) {
            System.out.println(Scripts.afterWord(files.get(i).getAbsolutePath(), "IV"));
        }
    }

}
