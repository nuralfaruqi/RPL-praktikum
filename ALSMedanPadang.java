package usk.eng.komputer.gotravel.Model;

public class ALSMedanPadang {

    private String namapemesan;
    private String jumlahtiket;
    private String hargatotal;


    public ALSMedanPadang(String id, String namapemesan, String jumlahtiket, String hargatotal) {
        this.namapemesan = namapemesan;
        this.jumlahtiket = jumlahtiket;
        this.hargatotal = hargatotal;
    }

    public String getNamapemesan() {
        return namapemesan;
    }
    public void setNamapemesan(String namapemesan) {
        this.namapemesan = namapemesan;
    }


    public String getJumlahtiket() {
        return jumlahtiket;
    }
    public void setJumlahtiket(String jumlahtiket) {
        this.jumlahtiket = jumlahtiket;
    }

    public String getHargatotal() {
        return hargatotal;
    }
    public void setHargatotal(String hargatotal) {
        this.hargatotal = hargatotal;
    }

}
