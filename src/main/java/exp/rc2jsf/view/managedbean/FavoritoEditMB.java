package exp.rc2jsf.view.managedbean;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import exp.rc2jsf.business.FavoritoBC;
import exp.rc2jsf.entity.Favorito;

@ViewController
@PreviousView("/favorito_list.xhtml")
public class FavoritoEditMB extends AbstractEditPageBean<Favorito, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private FavoritoBC bc;

	@Override
	@Transactional
	public String delete() {
		this.bc.delete(getId());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String insert() {
		this.bc.insert(getBean());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String update() {
		this.bc.update(getBean());
		return getPreviousView();
	}

	@Override
	protected void handleLoad() {
		setBean(this.bc.load(getId()));
	}

}
