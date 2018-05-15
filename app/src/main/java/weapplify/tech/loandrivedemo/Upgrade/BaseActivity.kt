package weapplify.tech.loandrivedemo.Upgrade


import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.database.MatrixCursor
import android.os.Bundle
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView

import java.util.HashMap

import weapplify.tech.loandrivedemo.R

open class BaseActivity : AppCompatActivity(), View.OnClickListener {
    lateinit open var context: Context
    lateinit open var activity: Activity
  lateinit  var baseLayout: LinearLayout
    lateinit var tvTitle: TextView
     var ivSearch: ImageView? = null
     var ivNotifications: ImageView? = null
     var ivLogout: ImageView? = null
    lateinit var ivClose: ImageView
    private val mDrawerToggle: ActionBarDrawerToggle? = null
     var mDrawer: DrawerLayout? = null
    lateinit var leftMenu: LinearLayout
    lateinit var llbottom: LinearLayout
    lateinit var icon: ImageView
    // RecyclerView rcvMenu;
     var ivBack: ImageView? = null
    //  DrawerMenuAdapter drawerMenuAdapter;
     var sumHeight: Int = 0
     var mtrxCursor: MatrixCursor? = null
     var itemHeight: HashMap<Int, Int>? = null

  lateinit  var llHeader: LinearLayout
 lateinit   var rlHeader: RelativeLayout
     var value: Boolean = false
    //final String[] matrix_columns = {MenuModel.MENU_ID, MenuModel.MENU_NAME, MenuModel.MENU_IMAGE};

     var sp: SharedPreferences? = null
     var editor: SharedPreferences.Editor? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        super.setContentView(R.layout.base_layout)
        context = this
        activity = this
        baseLayout = findViewById(R.id.baseLayout) as LinearLayout
        tvTitle = findViewById(R.id.tvActivityTitle) as TextView
        //ivLogout = (ImageView) findViewById(R.id.ivLogout);
        llHeader = findViewById(R.id.llHeader) as LinearLayout
        rlHeader = findViewById(R.id.app_heading) as RelativeLayout
        icon = findViewById(R.id.icon) as ImageView
        ivClose = findViewById(R.id.ivClose) as ImageView

        llbottom = findViewById(R.id.llbottom) as LinearLayout


        // sp = getSharedPreferences(App.clientData, context.MODE_PRIVATE);
        //  icon.setOnClickListener(this);
        /*   ivSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, Search.class);
                finish();
                startActivity(intent);


            }
        });*/

        /*   ivLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Login.class);
                editor = sp.edit();
                editor.remove(RegDetails.RD_NAME);
                editor.remove(RegDetails.RD_PASSWORD);
                editor.commit();
                finish();
                startActivity(intent);
            }
        });*/

        leftMenu = findViewById(R.id.leftMenu) as LinearLayout
        mDrawer = findViewById(R.id.drawer) as DrawerLayout
        ivClose.setOnClickListener(this)
        icon.setOnClickListener(this)
        //        mDrawer.setOnClickListener(this);
        // ivBack = (ImageView) findViewById(R.id.ivBack);
        // ivBack.setOnClickListener(this);


    }

    fun showbottomnavigation(value: Boolean?) {
        this.value = value!!
        if (value == false) {
            llbottom.visibility = View.GONE
        }

    }

    override fun setContentView(id: Int) {
        val inflater = baseContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(id, baseLayout)
    }

    override fun setTitle(ls_title: CharSequence) {
        tvTitle.text = ls_title
        //Toast.makeText(this, ls_title, Toast.LENGTH_SHORT).show();
    }

    override fun onClick(v: View) {
        //  super.onClick(v);
        when (v.id) {
            R.id.icon -> if (mDrawer!!.isDrawerOpen(Gravity.LEFT)) {
                closeDrawer()
            } else {
                mDrawer!!.openDrawer(leftMenu)
                //setupMenu();
            }
        /*
            case R.id.ivBack:
                if (mDrawer.isDrawerOpen(Gravity.LEFT)) {
                    closeDrawer();
                }
                break;*/

            R.id.ivClose -> onBackPressed()
        }
    }

    /* public void setupMenu() {
        rcvMenu = (RecyclerView) findViewById(R.id.rcvDrawerMenu);
        LinearLayoutManager llmMenu = new LinearLayoutManager(context);
        rcvMenu.setLayoutManager(llmMenu);


        mtrxCursor = new MatrixCursor(matrix_columns);
        int key = 0;

        mtrxCursor.addRow(new Object[]{key++, "New Prospect", "new_prospect"});
        mtrxCursor.addRow(new Object[]{key++, "Schedule Meeting", "schedule"});
        mtrxCursor.addRow(new Object[]{key++, "EMI Calculator", "emi"});
        mtrxCursor.addRow(new Object[]{key++, "Pocket Guide", "pocket_guide"});
        mtrxCursor.addRow(new Object[]{key++, "Competition Feedback", "review"});
        mtrxCursor.addRow(new Object[]{key++, "BDM Dashboard", "competitor"});


        rcvMenu = (RecyclerView) findViewById(R.id.rcvDrawerMenu);
        rcvMenu.setHasFixedSize(true);*/

    /*  StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        sglm.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        rcvMenu.setLayoutManager(sglm);
*/

    /*   drawerMenuAdapter = new DrawerMenuAdapter(context, mtrxCursor);
        rcvMenu.setAdapter(drawerMenuAdapter);
        drawerMenuAdapter.setOnItemClickListener(this);*/

    /* drawerMenuAdapter.setDynamicHeight(new DrawerMenuAdapter.DynamicHeight() {
            @Override
            public void HeightChange(int position, int height) {
                itemHeight.put(position, height);
                sumHeight = SumHashItem(itemHeight);

                float density = activity.getResources().getDisplayMetrics().density;
                float viewHeight = sumHeight * density;
                rcvMenu.getLayoutParams().height = (int) sumHeight;

                int i = rcvMenu.getLayoutParams().height;
            }
        });
*/
    //  }

    /*  @Override
    public void onItemClick(DrawerMenuAdapter adapter, View view, int position) {
        mtrxCursor.moveToPosition(position);
        Intent intent;
        Debugger.debug(TAG, "Item Clicked " + mtrxCursor.getString(mtrxCursor.getColumnIndex(MenuModel.MENU_NAME)));
        String lsMenuName = mtrxCursor.getString(mtrxCursor.getColumnIndex(MenuModel.MENU_NAME));
        if (lsMenuName.toUpperCase().equals("NEW PROSPECT")) {
            intent = new Intent(this, ProspectDetail.class);
            startActivity(intent);
        } else if (lsMenuName.toUpperCase().equals("SCHEDULE MEETING")) {
            intent = new Intent(this, MeetingDE.class);
            startActivity(intent);
        } else if (lsMenuName.toUpperCase().equals("EMI CALCULATOR")) {
            intent = new Intent(this, EmiCalculator.class);
            startActivity(intent);
        } else if (lsMenuName.toUpperCase().equals("COMPETITION FEEDBACK")) {
            intent = new Intent(this, CompetitionFeedback.class);
            startActivity(intent);
        } else if (lsMenuName.toUpperCase().equals("PERFORMANCE REVIEW")) {
            intent = new Intent(this, PerformanceReview.class);
            startActivity(intent);
        } else if (lsMenuName.toUpperCase().equals("BDM DASHBOARD")) {
            intent = new Intent(this, PerformanceReview.class);
            startActivity(intent);
        }

    }*/


    fun closeDrawer() {
        if (mDrawer != null) {
            mDrawer!!.closeDrawers()
        }
    }


    /*    int SumHashItem (HashMap<Integer, Integer> hashMap) {
            int sum = 0;

            for(Map.Entry<Integer, Integer> myItem: hashMap.entrySet())  {
                sum += myItem.getValue();
            }

            return sum;
        }*/
    override fun onBackPressed() {

        if (mDrawer!!.isDrawerOpen(Gravity.LEFT)) {
            mDrawer!!.closeDrawers()
            return
        } else {
            super.onBackPressed()
        }
    }

    companion object {
         var TAG = "BaseActivity"
    }

}