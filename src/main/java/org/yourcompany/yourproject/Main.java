package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author BoedNoNiwa
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] volumes = new int[n];

        for (int i = 0; i < n; i++) {
            volumes[i] = scanner.nextInt();
        }

        int volumeTotal = 0;
        for (int volume : volumes) {
            volumeTotal += volume;
        }

        int volumeTarget = volumeTotal / n;

        boolean bisa = true;
        int volumeTuang = 0;
        int tuangDari = -1;
        int tuangKe = -1;

        for (int i = 0; i < n; i++) {
            if (volumes[i] < volumeTarget) {
                if (tuangDari == -1) {
                    tuangDari = i;
                } else {
                    bisa = false;
                    break;
                }
            } else if (volumes[i] > volumeTarget) {
                if (tuangKe == -1) {
                    tuangKe = i;
                    volumeTuang = volumes[i] - volumeTarget;
                } else {
                    bisa = false;
                    break;
                }
            }
        }

        if (bisa) {
            if (tuangDari == -1 && tuangKe == -1) {
                System.out.println("SESUAI");
            } else if (tuangDari != -1 && tuangKe != -1) {
                System.out.println(volumeTuang + " " + (tuangDari + 1) + " " + (tuangKe + 1));
            } else {
                System.out.println("TIDAK SESUAI");
            }
        } else {
            System.out.println("TIDAK SESUAI");
        }
    }
}
