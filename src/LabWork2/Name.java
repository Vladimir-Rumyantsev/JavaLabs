package LabWork2;

public class Name {
    private String LastName;
    private String FirstName;
    private String Patronymic;

    public Name(String LastName, String FirstName, String Patronymic) {
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.Patronymic = Patronymic;
    }

    public Name(String LastName, String FirstName) {
        this(LastName, FirstName, null);
    }

    public Name(String FirstName) {
        this(null, FirstName, null);
    }

    public Name() {
        this(null, null, null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (LastName != null) {
            sb.append(LastName + " ");
        }

        if (FirstName != null) {
            sb.append(FirstName + " ");
        }

        if (Patronymic != null) {
            sb.append(Patronymic + " ");
        }

        if (sb.isEmpty()) {
            return "";
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setPatronymic(String Patronymic) {
        this.Patronymic = Patronymic;
    }

    public String getLastName() {
        return LastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getPatronymic() {
        return Patronymic;
    }
}

