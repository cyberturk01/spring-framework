package org.yigit.loosely_coupled;

public class MentorApp {
    public static void main(String[] args) {
        FullTimeMentor fullTime = new FullTimeMentor();
        //PartTimeMentor partTime = new PartTimeMentor();

        //Loosely Coupling comparing to tightly more handy and ideal to deal so many Object creation
        MentorAccount mentor = new MentorAccount(fullTime);

        mentor.manageAccount();
    }
}
