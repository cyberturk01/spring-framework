package org.yigit.loosely_coupled;

public class MentorApp {
    public static void main(String[] args) {
        Mentor fullTime = new FullTimeMentor();
        Mentor partTime = new PartTimeMentor();
        Mentor volunteer= new VolunteerMentor();

        //Loosely Coupling comparing to tightly more handy and ideal to deal so many Object creation
        MentorAccount mentor = new MentorAccount(fullTime);

        mentor.manageAccount();

        MentorAccount mentor2 = new MentorAccount(partTime);

        mentor2.manageAccount();

        MentorAccount mentor3 = new MentorAccount(volunteer);

        mentor3.manageAccount();
    }
}
