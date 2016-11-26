package net.a84jonghoon.app.androidtest01.message;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-11-26.
 */

public interface MessageService {

    public void add(MessageDTO param);
    public int count();
    public MessageDTO findOne();
    public ArrayList<MessageDTO> findBy(MessageDTO param);
    public ArrayList<MessageDTO> list();
    public void update(MessageDTO param);
    public void delete(MessageDTO param);
}
