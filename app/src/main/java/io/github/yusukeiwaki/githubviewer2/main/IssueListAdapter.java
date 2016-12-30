package io.github.yusukeiwaki.githubviewer2.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import io.github.yusukeiwaki.githubviewer2.R;
import io.github.yusukeiwaki.githubviewer2.model.Issue;

/**
 */
public class IssueListAdapter extends RecyclerView.Adapter<IssueViewHolder> {
    private final List<Issue> issueList = new ArrayList<>();

    public void updateIssueList(List<Issue> newIssueList) {
        issueList.clear();
        issueList.addAll(newIssueList);
        Collections.sort(issueList, new Comparator<Issue>() {
            @Override
            public int compare(Issue issue1, Issue issue2) {
                return issue2.getUpdated_at().compareTo(issue1.getUpdated_at());
            }
        });
        notifyDataSetChanged();
    }

    @Override
    public IssueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_issue, parent, false);
        return new IssueViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(IssueViewHolder holder, int position) {
        holder.bind(issueList.get(position));
    }

    @Override
    public int getItemCount() {
        return issueList.size();
    }
}