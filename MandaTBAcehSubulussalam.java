package usk.eng.komputer.gotravel.Model;

public class MandaTBAcehSubulussalam {

    private String namapemesan3;
    private String jumlahtiket3;
    private String hargatotal3;


    public MandaTBAcehSubulussalam(String id, String namapemesan, String jumlahtiket, String hargatotal) {
        this.namapemesan3 = namapemesan;
        this.jumlahtiket3 = jumlahtiket;
        this.hargatotal3 = hargatotal;
    }

    public String getNamapemesan() {
        return namapemesan3;
    }
    public void setNamapemesan(String namapemesan) {
        this.namapemesan3 = namapemesan;
    }


    public String getJumlahtiket() {
        return jumlahtiket3;
    }
    public void setJumlahtiket(String jumlahtiket) {
        this.jumlahtiket3 = jumlahtiket;
    }

    public String getHargatotal() {
        return hargatotal3;
    }
    public void setHargatotal(String hargatotal) {
        this.hargatotal3 = hargatotal;
    }


}
