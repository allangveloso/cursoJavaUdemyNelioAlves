package entities;

import java.text.SimpleDateFormat;
import java.util.List;

import java.util.ArrayList;
import java.util.Date;

public class Post {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date moment;
    private String title;
    private String content;
    private Integer likes;

    private List<Comment> comments = new ArrayList<>();

    public Post() {
    }

    public Post(Date moment, String title, String content, Integer likes) {
        this.moment = moment;
        this.title = title;
        this.content = content;
        this.likes = likes;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }
    //este set foi deletado porque não se deve receber uma lista, depois trocar a lista
    /*public void setComments(List<Comment> comments) {
        this.comments = comments;
    }*/

    //Deve-se criar um método específico para add itens à lista existente
    public void addComment(Comment coment) {
        comments.add(coment);
    }
    public void removeComment(Comment coment) {
        comments.remove(coment);
    }

    @Override
    //usar o StringBuilder é melhor quando se tem uma string muito grande
    public String toString() {
        StringBuilder sb = new StringBuilder();
                sb.append(title+"\n");
                sb.append(likes+ " likes - ");
                sb.append(sdf.format(moment)+"\n");
                sb.append(content+"\n");
                sb.append("Comments:"+"\n");
                for (Comment c : comments) {
                    sb.append(c.getText() + "\n");
                };
                sb.append("\n");
        //converte o sb para toString
        return sb.toString();
    }
}
