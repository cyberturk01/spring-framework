package org.yigit.tightly_coupled;

public class MentorApp {
    public static void main(String[] args) {

        FullTimeMentor fullTime = new FullTimeMentor();
        PartTimeMentor partTime = new PartTimeMentor();
        VolunteerMentor volunteerMentor= new VolunteerMentor();

        //If new Mentor type comes this tightly coupling is not ideal
        Mentor mentor = new Mentor(fullTime,partTime,volunteerMentor);
        mentor.manageAccount();
    }
}
