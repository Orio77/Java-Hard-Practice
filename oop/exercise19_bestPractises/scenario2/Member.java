package oop.exercise19_bestPractises.scenario2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Member {
    private String name;
    private int memberID;
    private List<Loan> loans;
    private MemberType type;
    private LoanPolicy policy;
    
    public Member(String name) {
        this.name = name;
        memberID = name.hashCode();
        loans = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        loans.add(new Loan(this, book, memberID));
    }
    public void removeLoan(Loan loan) {
        loans.remove(loan);
    }

    public List<Loan> getLoans() {
        return Collections.unmodifiableList(loans);
    }
    public int getMemberID() {
        return memberID;
    }
    public String getName() {
        return name;
    }

    public LoanPolicy getPolicy() {
        return policy;
    }
    public MemberType getType() {
        return type;
    }
    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }
    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }
}
