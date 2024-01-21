import java.util.Scanner;

class BankAccount {
    private String nomorRekening;
    private String pin;
    private double saldo;

    public BankAccount(String nomorRekening, String pin) {
        this.nomorRekening = nomorRekening;
        this.pin = pin;
        this.saldo = 0.0;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setor(double jumlah) {
        saldo += jumlah;
        System.out.println("Setoran tunai anda berhasil. Saldo : Rp" + saldo);
    }

    public void tarik(double jumlah) {
        if (jumlah <= saldo) {
            saldo -= jumlah;
            System.out.println("Penarikan tunai anda berhasil. Saldo : Rp" + saldo);
        } else {
            System.out.println("Saldo anda tidak mencukupi. Penarikan tunai anda gagal.");
        }
    }
}

class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nomor rekening Anda: ");
        String nomorRekening = scanner.nextLine().trim();

        System.out.print("Masukkan PIN Anda: ");
        String pin = scanner.nextLine().trim();

        // Use default values if user input is empty
        nomorRekening = nomorRekening.isEmpty() ? "123456789" : nomorRekening;
        pin = pin.isEmpty() ? "1234" : pin;

        BankAccount akun = new BankAccount(nomorRekening, pin);

        int pilihan;

        do {
            System.out.println("Menu ATM:");
            System.out.println("1. Cek Saldo");
            System.out.println("2. Setor Tunai");
            System.out.println("3. Tarik Tunai");
            System.out.println("4. Keluar");
            System.out.print("Masukkan pilihan Anda: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.println("Saldo: Rp" + akun.getSaldo());
                    break;
                case 2:
                    System.out.print("Masukkan jumlah setoran tunai: Rp");
                    double jumlahSetoran = scanner.nextDouble();
                    akun.setor(jumlahSetoran);
                    break;
                case 3:
                    System.out.print("Masukkan jumlah penarikan tunai: Rp");
                    double jumlahPenarikan = scanner.nextDouble();
                    akun.tarik(jumlahPenarikan);
                    break;
                case 4:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan anda tidak sesuai. Silakan coba lagi.");
            }

        } while (pilihan != 4);

        scanner.close();
    }
}
