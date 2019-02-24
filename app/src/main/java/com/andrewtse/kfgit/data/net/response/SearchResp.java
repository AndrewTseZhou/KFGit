package com.andrewtse.kfgit.data.net.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.andrewtse.kfgit.model.SearchModel;

import java.util.List;

/**
 * @author xk
 * @date 2019/2/22
 */
public class SearchResp implements Parcelable {

    private int total_count;
    private boolean incomplete_results;
    private List<SearchModel> items;

    public int getTotalCount() {
        return total_count;
    }

    public void setTotalCount(int totalCount) {
        this.total_count = totalCount;
    }

    public boolean isIncompleteResults() {
        return incomplete_results;
    }

    public void setIncompleteResults(boolean incompleteResults) {
        this.incomplete_results = incompleteResults;
    }

    public List<SearchModel> getItems() {
        return items;
    }

    public void setItems(List<SearchModel> items) {
        this.items = items;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.total_count);
        dest.writeByte(this.incomplete_results ? (byte) 1 : (byte) 0);
        dest.writeTypedList(this.items);
    }

    public SearchResp() {
    }

    protected SearchResp(Parcel in) {
        this.total_count = in.readInt();
        this.incomplete_results = in.readByte() != 0;
        this.items = in.createTypedArrayList(SearchModel.CREATOR);
    }

    public static final Parcelable.Creator<SearchResp> CREATOR = new Parcelable.Creator<SearchResp>() {
        @Override
        public SearchResp createFromParcel(Parcel source) {
            return new SearchResp(source);
        }

        @Override
        public SearchResp[] newArray(int size) {
            return new SearchResp[size];
        }
    };
}
