MVC structure in Android Development 
===================================

```java public class ListActivity extends BaseActivity implements ListViewMvcImpl.Listener {
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

Then generate a path in your code :

```java
ShapeOfView shapeOfView = findViewById(R.id.myShape)
shapeOfView.setClipPathCreator(new ClipPathManager.ClipPathCreator() {
       @Override
       public Path createClipPath(int width, int height) {
           final Path path = new Path();

            //eg: triangle
           path.moveTo(0, 0);
           path.lineTo(0.5 * width, height);
           path.lineTo(width, 0);
           path.close();

           return path;
       }
});
```
