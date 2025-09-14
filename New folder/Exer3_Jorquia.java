public class bloodyType {
    private String bloodType;
    
    public String getBloodType() {
        return bloodType;
    }
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
    public static void main(String[] args) {
        bloodyType bloodyType = new bloodyType();
    
        // setter
        bloodyType.setBloodType("A+");

        // getter
        System.out.println("Blood Type: " + bloodyType.getBloodType());
    }
}