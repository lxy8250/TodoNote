package lxy.com.todonote.addnote;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import lxy.com.todonote.base.BaseViewModel;
import lxy.com.todonote.data.NoteRepository;
import lxy.com.todonote.net.Resource;
import lxy.com.todonote.note.NoteModel;
import lxy.com.todonote.utils.CalendarReminderUtils;

public class AddTodoNoteViewModel extends BaseViewModel {
    public NoteRepository repository;

    public AddTodoNoteViewModel(@NonNull Application application) {
        super(application);
        repository = new NoteRepository();
    }

    public MutableLiveData<Resource<NoteModel>> addNote(String title,String content,
                                                        String dateStr,int type,int priority){
        return repository.addNote(title, content, dateStr, type, priority);

    }

    public MutableLiveData<Resource<NoteModel>> updateNote(int id,String title,String content,
                                                           String dateStr,int type){
        return repository.updateNote(id,title, content, dateStr, type);
    }

    public void addAlarmToCalendar(NoteModel model, Context context){
        CalendarReminderUtils.addCalendarEvent(context,model.getTitle(),model.getContent(),model.getDate(),1);
    }
}
