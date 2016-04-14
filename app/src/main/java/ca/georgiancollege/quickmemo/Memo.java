package ca.georgiancollege.quickmemo;

/**
 * Created by spike on 2016-04-08.
 */
public class Memo
{
    private String _title;
    private String _category;
    private String _date;
    private String _description;
    private boolean _isDone;

    public Memo()
    {
        this._title = "";
        this._category = "";
        this._date = "";
        this._description = "";
        this._isDone = false;
    } //constructor ends

    public Memo(String title, String category, String date, String description)
    {
        this._title = title;
        this._category = category;
        this._date = date;
        this._description = description;
        this._isDone = false;
    } //constructor ends

    public String getTitle()
    {
        return this._title;
    } //method getTitle ends

    public String getCategory()
    {
        return this._category;
    } //method getCategory ends

    public String getDate()
    {
        return this._date;
    } //method getCategory ends

    public String getDescription()
    {
        return this._description;
    } //method getDescription ends

    public boolean getIsDone()
    {
        return this._isDone;
    } //method getIsDone ends

    public void setTitle(String title)
    {
        this._title = title;
    } //method setTitle ends

    public void setCategory(String category)
    {
        this._category = category;
    } //method setCategory ends

    public void setDate(String date)
    {
        this._date = date;
    } //method setDate ends

    public void setDescription(String description)
    {
        this._description = description;
    } //method setDescription ends

    public void setIsDone(boolean isDone)
    {
        this._isDone = isDone;
    } //method setIsDone ends
} //class Memo ends
