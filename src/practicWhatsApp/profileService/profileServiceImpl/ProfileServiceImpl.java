package practicWhatsApp.profileService.profileServiceImpl;

import practicWhatsApp.classes.Contacts;
import practicWhatsApp.classes.Profile;
import practicWhatsApp.enam.Status;
import practicWhatsApp.myException.MyException;
import practicWhatsApp.profileService.ProfileService;


import javax.lang.model.type.ArrayType;
import javax.script.ScriptContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProfileServiceImpl implements ProfileService {
    static int counter;
    List<Profile> massage = new ArrayList<>();
    List<Profile> profiles = new ArrayList<>();
    List<Profile> contacts = new ArrayList<>();
    List<Profile> lists = new ArrayList<>();
    List<Profile> list = new ArrayList<>();
    List<Profile> lis = new ArrayList<>();

    @Override
    public void registrationToWhatsApp() {
        Profile profile = new Profile();


        try {
            System.out.println("Телефондун номерин жазыныз: ");
            String scanPhoneNumber = new Scanner(System.in).nextLine();
            if (!scanPhoneNumber.startsWith("0")) {
                throw new MyException("0 менен башталсын.\n ");
            }
            if (scanPhoneNumber.length() <= 9) {
                throw new MyException("Номерди толук жазыныз.\n");
            }
            for (Profile p : profiles) {
                if (p.getPhoneNumber().equals(scanPhoneNumber)) {
                    throw new MyException("Mындай номер бар.\n");
                }
            }
            System.out.println("Атын жызыныз: ");
            String scanName = new Scanner(System.in).nextLine();
            System.out.println("Пароль жазыныз: ");
            String scanPassword = new Scanner(System.in).nextLine();
            if (scanPassword.length() < 4) {
                throw new MyException("4 тон жогору сан же тамга жазыныз.\n ");
            }
            profile.setStatus(Status.MEN_WHATSAPP_KOLDONUP_JATAM);
            profile.setPhoto("Фото жок...");
            profile.setMassage(massage);
            profile.setPassword(scanPassword);
            profile.setPhoneNumber(scanPhoneNumber);
            profile.setUserName(scanName);
            profile.setId(++counter);
            profiles.add(profile);
            System.out.println("Профил катталды: " + profile.toString());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Profile getToProfile() {

        try {
            System.out.println("Профилдин атын жазыныз: ");
            String scanUserName = new Scanner(System.in).nextLine();
            System.out.println("Сыр соз жазыныз: ");
            String scanPassword = new Scanner(System.in).nextLine();
            for (Profile p : profiles) {
                if (p.getUserName().equalsIgnoreCase(scanUserName) && p.getPassword().equals(scanPassword)) {
                    lists.add(p);
                }
            }
            if (!lists.isEmpty()) {
                for (Profile p : profiles) {
                    if (p.getPassword().equals(scanPassword) && p.getUserName().equals(scanUserName))
                        System.out.println(p);
                }
            } else {
                throw new MyException("Мындай Profile табылган жок.");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    @Override
    public void getAllStatus() {
        List<Status> statusList = new ArrayList<>(Arrays.asList(Status.MEN_WHATSAPP_KOLDONUP_JATAM, Status.MEN_BAILANASHTAMYN, Status.JAZYNYZ_SUILOSHO_ALBAIM, Status.UKTAP_JATAM, Status.BOSH_EMESMIN));
        System.out.println("Статустарды коробуз: ");
        for (Status s : statusList) {
            System.out.println("    " + s + " ");
        }
    }

    @Override
    public Profile savePhotoToProfile() {

        try {
            System.out.println("Фото жуктойбуз.");
            System.out.println("Профилдин атын жазыныз: ");
            String scanUserName = new Scanner(System.in).nextLine();
            System.out.println("Сыр соз жазыныз: ");
            String scanPassword = new Scanner(System.in).nextLine();
            for (Profile p : profiles) {
                if (p.getUserName().equalsIgnoreCase(scanUserName) && p.getPassword().equals(scanPassword)) {
                    lists.add(p);
                }
            }
            if (!lists.isEmpty()) {
                for (Profile p : profiles) {
                    if (p.getPassword().equals(scanPassword) && p.getUserName().equals(scanUserName)) {
                        System.out.println(p);
                        System.out.println("Фотонун шилтемесин жуктонуз: ");
                        String scanFotoName = new Scanner(System.in).nextLine();
                        p.setPhoto(scanFotoName);
                        System.out.println(p);
                    }
                }
            } else {
                throw new MyException("Мындай Profile табылган жок.");
            }

        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Profile saveStatusToProfile() {

        try {
            System.out.println("Сатус кошобуз.");
            System.out.println("Профилдин атын жазыныз: ");
            String scanUserName = new Scanner(System.in).nextLine();
            System.out.println("Сыр соз жазыныз: ");
            String scanPassword = new Scanner(System.in).nextLine();
            for (Profile p : profiles) {
                if (p.getUserName().equals(scanUserName) && p.getPassword().equals(scanPassword)) {
                    list.add(p);
                }
            }
            if (!list.isEmpty()) {
                for (Profile p : profiles) {
                    if (p.getPassword().equals(scanPassword) && p.getUserName().equalsIgnoreCase(scanUserName)) {
                        System.out.print(p);
                        System.out.print("\nСтатусту танданыз: " +
                                "\n1-Мен байланыштамын. " +
                                "\n2-Мен ватсап колдонуп жатам. " +
                                "\n3-Мен бош эмесмин. " +
                                "\n4-Жазыныз, суйлошо албайм. " +
                                "\n5-Уктап жатам." +
                                "\n");
                        int scanStatus = new Scanner(System.in).nextInt();
                        switch (scanStatus) {
                            case 1:
                                p.setStatus(Status.MEN_BAILANASHTAMYN);
                                break;
                            case 2:
                                p.setStatus(Status.MEN_WHATSAPP_KOLDONUP_JATAM);
                                break;
                            case 3:
                                p.setStatus(Status.BOSH_EMESMIN);
                                break;
                            case 4:
                                p.setStatus(Status.JAZYNYZ_SUILOSHO_ALBAIM);
                                break;
                            case 5:
                                p.setStatus(Status.UKTAP_JATAM);
                        }
                        System.out.println(p);
                    }
                }
            } else {
                throw new MyException("Мындай Profile табылган жок.");
            }

        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Profile addContact() {
        Profile profile = new Profile();
        try {
            System.out.println("Профилдин атын жазыныз.");
            String scanName = new Scanner(System.in).nextLine();
            System.out.println("Сыр соз жазыныз.");
            String scanPassword = new Scanner(System.in).nextLine();
            for (Profile p : profiles) {
                if (p.getUserName().equalsIgnoreCase(scanName) && (p.getPassword().equalsIgnoreCase(scanPassword))) {
                    System.out.println("Контактын атын жазыныз. ");
                    String scanNameCont = new Scanner(System.in).nextLine();
                    System.out.println("Контактын номерин жазыныз. ");
                    String scanNumberCont = new Scanner(System.in).nextLine();
                    if (!scanNumberCont.startsWith("0")) {
                        throw new MyException("0 менен башталсын.\n ");
                    }
                    if (scanNumberCont.length() <= 9) {
                        throw new MyException("Номерди толук жазыныз.\n");
                    }
                    profile.setContName(scanNameCont);
                    profile.setContName(scanNumberCont);
                    profile.setId(++counter);
                    profiles.add(profile);
                    System.out.println(profile);
                }
            }
        } catch (MyException e) {
            throw new RuntimeException(e);
        }


        /*try {
            System.out.println("Профилдин атын жазыныз: ");
            String scanUserName = new Scanner(System.in).nextLine();
            System.out.println("Сыр соз жазыныз: ");
            String scanPassword = new Scanner(System.in).nextLine();
            for (Profile p : profiles) {
                if (p.getUserName().equals(scanUserName) && p.getPassword().equals(scanPassword)) {
                    list.add(p);
                }
            }
            if (!list.isEmpty()) {
                for (Profile p : profiles) {
                    if (p.getPassword().equals(scanPassword) &&
                            p.getUserName().equals(scanUserName)) {
                        System.out.println(p);
                    } else {
                        throw new MyException("Мындай ном жок");
                    }
                }
                System.out.println("Ватсап номер жазыныз: ");
                String scanWatsNumber = new Scanner(System.in).nextLine();
                for (Profile p: profiles) {
                    if (p.getPhoneNumber().equals(scanWatsNumber)){
                        p.setPhoneNumber(scanWatsNumber);
                        System.out.println(p);
                    } else {
                        throw new MyException("Мындай номер катталган эмес. ");
                    }
                }

            } else {
                throw new MyException("Мындай ватсап номер Profilде табылган жок.");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }*/
        return null;
    }
    @Override
    public String writingMassage() {
        return null;
    }

    @Override
    public void deleteWhatsApp() {

    }
}
