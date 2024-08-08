package application;
import entities.Comment;
import entities.Post;
import java.text.ParseException;
import java.util.*;

public class App 
{
    public static void main( String[] args ) throws ParseException {
        Scanner sc = new Scanner(System.in);
        Calendar cal = Calendar.getInstance();
        Random random = new Random();

        List<Post> posts = new ArrayList<>();

        char x = 's';

        while (x == 's') {
            System.out.print("Insira o título de uma postagem: ");
            String title = sc.nextLine();
            System.out.print("Insira o conteúdo do post: ");
            String content = sc.nextLine();
            int likes = random.nextInt(999);

            Post post = new Post(cal.getTime(), title, content, likes);

            System.out.print("Deseja fazer um comentário? (s/n) : ");
            char op = sc.nextLine().charAt(0);
            while (op == 's') {
                System.out.print("Insira o comentário: ");
                Comment comment = new Comment(sc.nextLine());
                post.addComment(comment);

                System.out.print("Deseja fazer outro comentário? (s/n) : ");
                op = sc.nextLine().charAt(0);
            }
            posts.add(post);

            System.out.print("Deseja fazer outra postagem? (s/n) : ");
            x = sc.nextLine().charAt(0);
        }
        System.out.println();
        System.out.println(posts);//printa o array de posts


/*
        //ATRIBUINDO VALORES DIRETAMENTE NO CÓDIGO (HARD CODE)
        //POST 1
        Post p1 = new Post(
                sdf.parse("21/06/2018 13:05:44"),
                "Traveling to New Zaeland",
                "I'm going to visit this wonderful country!",
                12
        );
        Comment c1 = new Comment("Have a nice trip");
        Comment c2 = new Comment("Wow that is awesome");

        p1.addComment(c1);
        p1.addComment(c2);

        System.out.println(p1);

        //POST 2
        Post p2 = new Post(
                sdf.parse("28/07/2018 23:14:19"),
                "Good night guys",
                "See you tomorrow",
                5
        );
        Comment c3 = new Comment("Good night");
        Comment c4 = new Comment("May the Force be with you");

        p2.addComment(c3);
        p2.addComment(c4);

        System.out.println(p2);
*/
    }
}
