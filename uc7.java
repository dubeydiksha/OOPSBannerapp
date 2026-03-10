public class uc7 {
    static class CharacterPatternMap {
        Character character;
        String[] pattern;
        
        public CharacterPatternMap(Character character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }

        public Character getCharacter() {
            return character;
        }

        public String[] getPattern() {
            return pattern;
        }
        
    }

    public static CharacterPatternMap[] createCharacterPatternMaps() {
        CharacterPatternMap[] characterPatternMaps = new CharacterPatternMap[3];
        
        characterPatternMaps[0] = new CharacterPatternMap('O', new String[] {
            "   *****    ",
            " **     **  ",
            "**       ** ",
            "**       ** ",
            "**       ** ",
            " **     **  ",
            "   *****    ",
        });

        characterPatternMaps[1] = new CharacterPatternMap('P', new String[] {
            "********* ",
            "**     ** ",
            "**     ** ",
            "********* ",
            "**        ",
            "**        ",
            "**        "
        });

        characterPatternMaps[2] = new CharacterPatternMap('S', new String[] {
            "  ******  ",
            "**      **",
            "**       ",
            "  ******  ",
            "        ** ",
            "**      ** ",
            "  ******  "
        });

        return characterPatternMaps;
    }

    public static String[] getCharacterPattern(char ch, CharacterPatternMap[] charMaps) {
        for (CharacterPatternMap charMap : charMaps) {
            if (charMap.getCharacter() == ch) {
                return charMap.getPattern();
            }
        }
        return null  ; 
    }

    public static void printMessage(String message, CharacterPatternMap[] charMaps) {
        String[] outputLines = new String[7];
        for (int i = 0; i < outputLines.length; i++) {
            outputLines[i] = "";
        }

        for (char ch : message.toCharArray()) {
            String[] charPattern = getCharacterPattern(ch, charMaps);
            if (charPattern != null) {
                for (int i = 0; i < charPattern.length; i++) {
                    outputLines[i] += charPattern[i] + " ";
                }
            }
        }

        for (String line : outputLines) {
            System.out.println(line);
        }
    }

    public static void main(String[] args) {
        CharacterPatternMap[] charMaps = createCharacterPatternMaps();
        String message = "OOPS";
        printMessage(message, charMaps);
    }
}
