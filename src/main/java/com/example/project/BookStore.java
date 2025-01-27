package com.example.project;


public class BookStore{


    //requires at least 2 attributes Book[] books, User[] users (initialized to an empty array of 10 max users)
    private Book[] books = new Book[0];
    private User[] users = new User[10];
    //requires 1 empty constructor
    public BookStore(){}
    public User[] getUsers(){
        return users;
    }


    public void setUsers(User[] users){
        this.users = users;
    }


    public Book[] getBooks(){
        return books;
    }


    public void addUser(User user){
        for (int i = 0; i < users.length; i++){
            if (users[i] == null){
                users[i] = user;
                consolidateUsers();
                return;
            }
        }
    }


    public void removeUser(User user){
        for (int i = 0; i < users.length; i++){
            if (users[i] == user){
                users[i] = null;
                consolidateUsers();
                return;
            }
        }
    }


    public void consolidateUsers(){ //moves all null elements to the end of the list
        int nextEmpty = 0;
        for (int i = 0; i < users.length; i++){
            if (users[i] != null){
                if (i != nextEmpty){
                    users[nextEmpty] = users[i];
                    users[i] = null;
                }
                nextEmpty++;
            }
        }
    }


    public void addBook(Book book){
        int newLength = books.length + 1;
        Book[] newBooks = new Book[newLength];
        for (int i = 0; i < books.length; i++){
            newBooks[i] = books[i];
        }
        newBooks[newLength - 1] = book;
        books = newBooks;
    }


    public void insertBook(Book book, int index){
        Book[] newBooks = new Book[books.length + 1];
        for (int i = 0; i < index; i++){
            newBooks[i] = books[i];
        }
        for (int i = index + 1; i < newBooks.length; i++){
            newBooks[i] = books[i - 1];
        }
        newBooks[index] = book;
        books = newBooks;
    }


    public void removeBook(Book book){
        int index = 0;
        for (int i = 0; i < books.length; i++){
            if (books[i] == book){
                index = i;
            }
        }
        if (books[index].getQuantity() == 1){
            Book[] newList = new Book[books.length - 1];
            for (int i = 0; i < index; i++){
                newList[i] = books[i];
            }
            for (int i = index + 1; i < books.length; i++){
                newList[i - 1] = books[i];
            }
            books = newList;
        }else {
            books[index].setQuantity(books[index].getQuantity() - 1);
        }
    }
       
    public String bookStoreBookInfo(){
        String result = "";
        for (int i = 0; i < books.length; i++){
            result += books[i].bookInfo() + "\n";
        }
        return result;
    } //you are not tested on this method but use it for debugging purposes


    public String bookStoreUserInfo(){
        String result = "";
        for (int i = 0; i < users.length; i++){
            if (users[i] != null){
                result += users[i].userInfo() + "\n";
            }
        }
        return result;
    } //you are not tested on this method but use it for debugging purposes


}