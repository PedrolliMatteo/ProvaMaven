import com.github.lalyos.jfiglet.FigletFont;
import net.datafaker.Faker;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import static java.lang.IO.println;

void main() throws IOException {
    Faker faker = new Faker();

    println("Citazione bella di Chuck Norris: " + faker.chuckNorris().fact());
    println("Pokemon selvatico: " + faker.pokemon().name());

    String asciiArt = FigletFont.convertOneLine("Che figone che sono");
    println(asciiArt);

    File destinazione = new File("qrcode.png");
    File file = QRCode.from("https://www.google.com/?hl=it")
            .to(ImageType.PNG)
            .file();
    Files.copy(file.toPath(), destinazione.toPath(), StandardCopyOption.REPLACE_EXISTING);
    println("QR CODE GENERATO: " + file.getAbsolutePath());
}