object CharacterTree {

      def rec_tree(numSpaces: Int,numSym:Int, height: Int, char:Char): Unit ={
        if(height == 0){
          return
        }
        print_level(numSpaces,' ')
        print_level(numSym,char)
        println()
        rec_tree(numSpaces-1,numSym+2,height-1,char)
      }

      def print_level(level:Int,char:Char): Unit ={
        if(level == 0){
          return
        }
        print(char)
        print_level(level-1,char)
      }

      def print_tree(height: Int) {
        print_tree_char(height,'*')
      }
      
      def print_tree_char(height: Int, char: Char) {
        rec_tree(height-1,1,height,char)
        rec_tree(height-1,1,1,char)
      }

      def main(args: Array[String]) {
        var foo: Int = 14
        print_tree(foo)
        print_tree_char(foo, 'o');
      }
   }
