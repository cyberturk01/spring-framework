package org.yigit.tightly_coupled;

public class Mentor {
    FullTimeMentor fullTimeMentor;
    PartTimeMentor partTimeMentor;
    VolunteerMentor volunteerMentor;

    public Mentor(FullTimeMentor fullTimeMentor, PartTimeMentor partTimeMentor, VolunteerMentor volunteerMentor) {
        this.fullTimeMentor = fullTimeMentor;
        this.partTimeMentor = partTimeMentor;
        this.volunteerMentor = volunteerMentor;
    }

    public void manageAccount(){
        fullTimeMentor.createAccount();
        partTimeMentor.createAccount();
        volunteerMentor.createAccount();
    }
}
