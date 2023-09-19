package org.yigit.loosely_coupled;

public class VolunteerMentor implements Mentor{
    @Override
    public void createAccount() {
        System.out.println("Only Weekends");
    }
}
