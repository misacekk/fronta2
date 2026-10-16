public class Uchazec {
    private String jmeno;
    private String prijmeni;
    private String vzdělání;
    private String pozice;
    private int vek;

    public Uchazec(String jmeno, String prijmeni, String vzdělání, String pozice, int vek) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vzdělání = vzdělání;
        this.pozice = pozice;
        this.vek = vek;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public String getVzdělání() {
        return vzdělání;
    }

    public void setVzdělání(String vzdělání) {
        this.vzdělání = vzdělání;
    }

    public String getPozice() {
        return pozice;
    }

    public void setPozice(String pozice) {
        this.pozice = pozice;
    }

    public int getVek() {
        return vek;
    }

    public void setVek(int vek) {
        this.vek = vek;
    }

    public String getCeleJmeno() {
        return jmeno + " " + prijmeni;
    }

    @Override
    public String toString() {
        return "Uchazec{" +
                "jmeno='" + jmeno + '\'' +
                ", vzdělání='" + vzdělání + '\'' +
                ", pozice='" + pozice + '\'' +
                ", vek=" + vek +
                '}';
    }
}
