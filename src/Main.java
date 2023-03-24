import practicWhatsApp.classes.Profile;
import practicWhatsApp.myException.MyException;
import practicWhatsApp.profileService.profileServiceImpl.ProfileServiceImpl;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Profile> profiles = new ArrayList<>();
        ProfileServiceImpl profileService = new ProfileServiceImpl();
        boolean bool = true;
        while (bool) {
            try {
                System.out.println("0-басып Ватсап орнотуп алыныз.");
                int scanZero = new Scanner(System.in).nextInt();
                if (scanZero == 0) {
                    System.out.println("Ватсап орнотулду... кийинки кадам.");
                }
                switch (scanZero) {
                    case 0: {
                        try {
                            boolean isTrue = true;
                            while (isTrue) {
                                System.out.println("""
                                        1-> WhatsApp'ка катталыныз. 
                                        2-> Профилге киребиз. 
                                        3-> Бардык статусту коробуз. 
                                        4-> Профилге фото жуктойбуз. 
                                        5-> Профилге сатус кошобуз. 
                                        6-> Контакт кошобуз. 
                                        7-> СМС жазабыз. 
                                        8-> WhatsApp'ты очуробуз. 
                                        """);
                                int scanCase = new Scanner(System.in).nextInt();
                                switch (scanCase) {
                                    case 1:
                                        profileService.registrationToWhatsApp();
                                        break;
                                    case 2:
                                        profileService.getToProfile();
                                        break;
                                    case 3:
                                        profileService.getAllStatus();
                                        break;
                                    case 4:
                                        profileService.savePhotoToProfile();
                                        break;
                                    case 5:
                                        profileService.saveStatusToProfile();
                                        break;
                                    case 6:
                                        profileService.addContact();
                                        break;
                                }
                            }
                            bool = true;
                        } catch (Exception e) {
                            throw new RuntimeException(e.getMessage());
                        }
                    }
                }
            } catch (InputMismatchException i) {
                System.out.println("0 ду жазыныз.");
            }
        }
    }
}