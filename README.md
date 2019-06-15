MVC structure in Android Development 
===================================


MainActivity:

```java 
public class ListActivity extends BaseActivity implements ListViewMvcImpl.Listener {
    private List<Data> mDataList = new ArrayList<>();
    private ListViewMvc mViewMvc;

    @Override
    protected void onStart() {
        super.onStart();
        getData();
    }

    private void getData() {
        bindData(mDataList);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFakeData();
        mViewMvc = new ListViewMvcImpl(LayoutInflater.from(this),null);
        mViewMvc.registerListener(this);
        setContentView(mViewMvc.getRootView());
    }
```

ViewMvc:
```java
interface ListViewMvc extends ObservableViewMvc<ListViewMvc.Listener> {

    public interface Listener {
        void onDataClicked(Data data);
    }

    void bindDatas(List<Data> datas);

}
```

ViewMvcImp:
```java
public class ListItemViewMvcImpl extends BaseObservableViewMvc<ListItemViewMvc.Listener>
        implements ListItemViewMvc {

    private final TextView mTxtTitle;
    private Data mData;

    public ListItemViewMvcImpl(LayoutInflater inflater, @Nullable ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.layout_question_list_item, parent, false));
        mTxtTitle = findViewById(R.id.txt_title);
        getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Listener listener : getListeners()) {
                    listener.onDataClicked(mData);
                }
            }
        });
    }

    @Override
    public void bindData(Data data) {
        mData = data;
        mTxtTitle.setText(data.getTitle());
    }
}
```

BaseObservableViewMvc
```java
public abstract class BaseObservableViewMvc<ListenerType> extends BaseViewMvc
        implements ObservableViewMvc<ListenerType> {

    private Set<ListenerType> mListeners = new HashSet<>();

    @Override
    public void registerListener(ListenerType listener) {
        mListeners.add(listener);
    }

    @Override
    public void unregisterListener(ListenerType listener) {
        mListeners.remove(listener);
    }

    protected Set<ListenerType> getListeners() {
        return Collections.unmodifiableSet(mListeners);
    }
}
```
