package Library.core;

import java.util.List;

public interface IArticleContained extends ILibraryItem {
	List<IArticle>getArticles();
}
