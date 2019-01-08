package usk.eng.komputer.gotravel.Model;

public class ALSBAcehMedan {

    private String namapemesan1;
    private String jumlahtiket1;
    private String hargatotal1;


    public ALSBAcehMedan(String id, String namapemesan, String jumlahtiket, String hargatotal) {
        this.namapemesan1 = namapemesan;
        this.jumlahtiket1 = jumlahtiket;
        this.hargatotal1 = hargatotal;
    }

    public String getNamapemesan() {
        return namapemesan1;
    }
    public void setNamapemesan(String namapemesan) {
        this.namapemesan1 = namapemesan;
    }


    public String getJumlahtiket() {
        return jumlahtiket1;
    }
    public void setJumlahtiket(String jumlahtiket) {
        this.jumlahtiket1 = jumlahtiket;
    }

    public String getHargatotal() {
        return hargatotal1;
    }
    public void setHargatotal(String hargatotal) {
        this.hargatotal1 = hargatotal;
    }

}
