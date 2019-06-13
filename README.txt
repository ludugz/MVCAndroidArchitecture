MVC structure in Android Development 
===================================

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
