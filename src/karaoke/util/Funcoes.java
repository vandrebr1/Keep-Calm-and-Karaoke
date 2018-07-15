package karaoke.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumMap;
import java.util.Locale;
import java.util.Map;
import javax.imageio.ImageIO;

public class Funcoes {

    public static String primeiraMaiuscula(String frase) {
        StringBuffer sb = new StringBuffer(frase);
        for (int i = 0; i < sb.length(); i++) {
            if ((i == 0) || (sb.charAt(i - 1) == ' ')) {
                sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
            }
        }
        return sb.toString();
    }

    public static void qrCodeGenerator(String myCodeText, int size, String fileName) {
        String fileType = "png";
        String filePath = System.getProperty("user.dir") + "\\" + fileName + "." + fileType;
        File myFile = new File(filePath);

        try {
            Map<EncodeHintType, Object> hintMap = new EnumMap(EncodeHintType.class);
            hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");

            hintMap.put(EncodeHintType.MARGIN, 1);

            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix byteMatrix = qrCodeWriter.encode(myCodeText, BarcodeFormat.QR_CODE, size, size, hintMap);

            int CrunchifyWidth = byteMatrix.getWidth();
            BufferedImage image = new BufferedImage(CrunchifyWidth, CrunchifyWidth, BufferedImage.TYPE_INT_RGB);

            image.createGraphics();

            Graphics2D graphics = (Graphics2D) image.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, CrunchifyWidth, CrunchifyWidth);
            graphics.setColor(Color.BLACK);

            for (int i = 0; i < CrunchifyWidth; i++) {
                for (int j = 0; j < CrunchifyWidth; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }
            ImageIO.write(image, fileType, myFile);
        } catch (WriterException e) {
            System.out.println("Erro ao gerar arquvo. WriterException: " + e);
        } catch (IOException e) {
            System.out.println("Erro ao gerar arquvo. IOException: " + e);
        }
        System.out.println("You have successfully created QR Code.");
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }

        return true;
    }

    public static String formatarDataHora(Date data, String formato) {
        if (data == null) {
            return null;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat(formato,
                Locale.getDefault());

        return dateFormat.format(data);
    }

    public static Date formatarDataHora(String data, String formato) {
        if (data == null || data.equals("")) {
            return null;
        }

        Date retorno = null;
        try {
            DateFormat dateFormat = new SimpleDateFormat(formato,
                    Locale.getDefault());
            retorno = (Date) dateFormat.parse(data);
        } catch (ParseException e) {
            return null;
        }
        return retorno;
    }

    public static String formatarDecimal(double valor, int qtdCasas) {
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat
                .getCurrencyInstance();

        String decimalSeparator = String.valueOf(decimalFormat
                .getDecimalFormatSymbols().getDecimalSeparator());

        if (qtdCasas == 0) {
            return String.valueOf(valor).replace(".", decimalSeparator);
        } else {
            return String.format("%." + String.valueOf(qtdCasas) + "f", valor)
                    .replace(".", decimalSeparator);
        }
    }
}
