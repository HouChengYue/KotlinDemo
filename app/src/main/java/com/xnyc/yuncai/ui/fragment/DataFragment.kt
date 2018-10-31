package com.xnyc.yuncai.ui.fragment

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.trello.rxlifecycle2.android.FragmentEvent
import com.trello.rxlifecycle2.kotlin.bindUntilEvent
import com.xnyc.yuncai.R
import com.xnyc.yuncai.base.BaseBindFragment
import com.xnyc.yuncai.databinding.DataFragmentLayotBinding
import com.xnyc.yuncai.moudle.bean.Repo
import com.xnyc.yuncai.moudle.net.ApiClient
import com.xnyc.yuncai.moudle.net.ApiErroModle
import com.xnyc.yuncai.moudle.net.ApiResponse
import com.xnyc.yuncai.moudle.net.NetworkScheduler
import kotlinx.android.synthetic.main.data_fragment_layot.*

/**
 * Creat by HCY on2018/10/31
 * 描述：
 */
class DataFragment : BaseBindFragment<DataFragmentLayotBinding>() {
    lateinit var viewModle: DataFragmentViewModle;
    companion object {
        fun newInstance() = DataFragment()
    }


    override fun setLayout(): Int {
        return R.layout.data_fragment_layot
    }

    override fun initView() {
        viewModle = ViewModelProviders.of(this).get(DataFragmentViewModle::class.java)
        mBinding.bean = viewModle
        btnSummit.setOnClickListener {
            if (viewModle.userName.equals("")) {
                Toast.makeText(activity, "请输入用户名", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            getData()
        }

    }

    private fun getData() {
        ApiClient.instance.service.listRepos(viewModle.userName)
            .compose(NetworkScheduler.compose())
            .bindUntilEvent( this,FragmentEvent.DESTROY)
            .subscribe(object : ApiResponse<List<Repo>>(context as Context) {
                override fun success(data: List<Repo>) {
                    viewModle.ivShow = "返回结果：\n  用户名：${data[0].owner.login} \n" +
                            " 仓库名：${data[0].name}\n" +
                            "描述：${data[0].html_url}"
                    tvShow.text = viewModle.ivShow
                }

                override fun failure(statusCodes: Int, apiErrroModel: ApiErroModle) {
                    Toast.makeText(context, "错误${apiErrroModel.message}", Toast.LENGTH_SHORT).show()
                }
            })
    }

    override fun loadData() {

    }

}

class DataFragmentViewModle : ViewModel() {
    var userName: String = ""

    var ivShow: String = "There are nothing!"


}

