package practicWhatsApp.profileService;

import practicWhatsApp.classes.Profile;
import practicWhatsApp.enam.Status;

public interface ProfileService {


    void registrationToWhatsApp();
    Profile getToProfile();
    void getAllStatus();
    Profile savePhotoToProfile();
    Profile saveStatusToProfile();
    Profile addContact();
    String writingMassage();
    void deleteWhatsApp();

}
