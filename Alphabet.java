public class Alphabet {
    private String alphabet;

    Alphabet(){
        this.alphabet = new String("АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ");
    }

    public void crossOutTheLetter(String letter) {
        this.alphabet.replace(letter, "*");
    }

    public boolean checkIfLetterIsAvailable(String letter) {
        int letterIndex = this.alphabet.indexOf(letter);
        return letterIndex != -1;
    }
}
