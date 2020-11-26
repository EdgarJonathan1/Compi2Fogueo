function pause(){
   read -p "$*"
}


java -jar /home/jonathan/IdeaProjects/CompiFogueo/lib/jflex-full-1.7.0.jar A_Lexico.jflex --encoding utf-8

pause '\nPress [Enter] key to continue...\n'


java -jar /home/jonathan/IdeaProjects/CompiFogueo/lib/java-cup-11b.jar -parser ASintactico -symbols Simbolos A_Sintactico.cup



