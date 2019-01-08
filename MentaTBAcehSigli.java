package usk.eng.komputer.gotravel.Model;

public class MentaTBAcehSigli {

    private String namapemesan2;
    private String jumlahtiket2;
    private String hargatotal2;


    public MentaTBAcehSigli(String id, String namapemesan, String jumlahtiket, String hargatotal) {
        this.namapemesan2 = namapemesan;
        this.jumlahtiket2 = jumlahtiket;
        this.hargatotal2 = hargatotal;
    }

    public String getNamapemesan() {
        return namapemesan2;
    }
    public void setNamapemesan(String namapemesan) {
        this.namapemesan2 = namapemesan;
    }


    public String getJumlahtiket() {
        return jumlahtiket2;
    }
    public void setJumlahtiket(String jumlahtiket) {
        this.jumlahtiket2 = jumlahtiket;
    }

    public String getHargatotal() {
        return hargatotal2;
    }
    public void setHargatotal(String hargatotal) {
        this.hargatotal2 = hargatotal;
    }

}


