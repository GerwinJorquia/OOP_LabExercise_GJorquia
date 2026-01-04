import java.time.LocalDate;

public class Transactor {
    private String name;
    private String address;
    private String contact;
    private String problem;
    private String residence;
    private LocalDate date;

    public Transactor() {}

    public Transactor(String name, String address, String contact, String problem, String residence, LocalDate date) {
        this.name = name; this.address = address; this.contact = contact; this.problem = problem; this.residence = residence; this.date = date;
    }

    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getContact() { return contact; }
    public String getProblem() { return problem; }
    public String getResidence() { return residence; }
    public LocalDate getDate() { return date; }

    public String toCSV() {
        return String.format("%s,%s,%s,%s,%s,%d-%02d-%02d", escape(name), escape(address), escape(contact), escape(problem), escape(residence), date.getYear(), date.getMonthValue(), date.getDayOfMonth());
    }

    private String escape(String s) { if (s == null) return ""; return s.replace("\n"," ").replace(","," "); }
}
